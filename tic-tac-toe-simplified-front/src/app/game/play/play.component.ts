import { Component, OnInit,Input  } from '@angular/core';
import { GameServiceService } from '../../services/game-service.service';;

import { 
	ApiResponse,
	PlayerModel,
	BoardPositionModel,
	Position,
	GameResult,
	PickBoxAction,
	GameModel } from '../../types/types';

@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.css']
})
export class PlayComponent implements OnInit {

	@Input('game') game: GameModel;
	@Input('gameResult') gameResult: GameResult;
	@Input('gameTable') gameTable:any;
	@Input('currentplayeruuid') currentplayeruuid : string;

	position : Position;
	constructor(private gameService:GameServiceService) { }
	ngOnInit(): void {
		this.currentplayeruuid = null;
		this.position = {
			vertical : 0,
			horizontal : 0
		}
	}

	play(position) {
		if (!position.value) {
			if(!this.currentplayeruuid) {
				this.currentplayeruuid = this.game.firstPlayer.uuid;
			} 
			this.gameService.check({
				playerUuid : this.currentplayeruuid,
				gameUuid : this.game.uuid,
				vertical : position.vertical,
				horizontal : position.horizontal
			}, this.gameResult, this.gameTable);
			position.value = this.currentplayeruuid == this.game.firstPlayer.uuid ? "X": "O";
			this.currentplayeruuid = this.currentplayeruuid == this.game.firstPlayer.uuid ?
				this.game.secondPlayer.uuid : this.game.firstPlayer.uuid;
		}

	}
}
