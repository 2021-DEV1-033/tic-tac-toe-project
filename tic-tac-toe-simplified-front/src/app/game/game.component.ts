import { Component, OnInit } from '@angular/core';
import { GameServiceService } from '../services/game-service.service';;

import { 
	ApiResponse,
	PlayerModel,
	BoardPositionModel,
	Position,
	GameResult,
	PickBoxAction,
	GameModel } from '../types/types';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

	currentplayeruuid : string;
	game: GameModel = {
		uuid : null,
		firstPlayer : {
			name : "Player 1",
			uuid: null
		},
		secondPlayer :  {
			name : "Player 2",
			uuid: null
		},
		boardPositions : null
	}
	gameResult = {
      winner : null,
      wonLineType: null,
      lastPlayedPosition : null,
      gameStatus : "IN_PROGRESS"
    }
	gameTable = new Array(3);

	constructor(private gameService : GameServiceService) { }

	ngOnInit(): void {
	}

	createGame(game: GameModel) {
		this.game.uuid = null;
		this.gameResult = {
			winner : null,
			wonLineType: null,
			lastPlayedPosition : null,
			gameStatus : "IN_PROGRESS"
		}
		this.gameTable = [
			new Array(3),
			new Array(3),
			new Array(3)
		]
		this.gameTable[0][0] = {horizontal :0,vertical :0};
		this.gameTable[0][1] = {horizontal :0,vertical :1};
		this.gameTable[0][2] = {horizontal :0,vertical :2};
		this.gameTable[1][0] = {horizontal :1,vertical :0};
		this.gameTable[1][1] = {horizontal :1,vertical :1};
		this.gameTable[1][2] = {horizontal :1,vertical :2};
		this.gameTable[2][0] = {horizontal :2,vertical :0};
		this.gameTable[2][1] = {horizontal :2,vertical :1};
		this.gameTable[2][2] = {horizontal :2,vertical :2};
		this.currentplayeruuid = null;

		this.gameService.createGame(game);
	}

}
