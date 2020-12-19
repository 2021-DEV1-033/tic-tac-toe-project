import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { 
  ApiResponse,
  PlayerModel,
  BoardPositionModel,
  Position,
  GameResult,
  PickBoxAction,
  GameModel } from '../types/types';

@Injectable({
  providedIn: 'root'
})
export class GameServiceService {

  constructor(private http: HttpClient) { }

  createGame(gameModel : GameModel){
    this.http.post<ApiResponse<GameModel>>("http://localhost:3001/play/new-game",
      gameModel).subscribe(res => {
            gameModel.firstPlayer = res.data.firstPlayer;
            gameModel.secondPlayer = res.data.secondPlayer;
            gameModel.uuid = res.data.uuid;
            gameModel.boardPositions = res.data.boardPositions;
        });
  }

  check(pickBoxAction : PickBoxAction, result : GameResult, gameTable : any[][]){
    this.http.put<ApiResponse<GameResult>>("http://localhost:3001/play/pick-a-box",
      pickBoxAction).subscribe(res => {
          result.winner = res.data.winner;
          result.wonLineType = res.data.wonLineType;
          result.lastPlayedPosition = res.data.lastPlayedPosition;
          result.gameStatus = res.data.gameStatus;
          if (result.wonLineType == 'HORIZONTAL') {
            gameTable[result.lastPlayedPosition.horizontal][0].win = true;
            gameTable[result.lastPlayedPosition.horizontal][1].win = true;
            gameTable[result.lastPlayedPosition.horizontal][2].win = true;
          } else if (result.wonLineType == 'VERTICAL') {
            gameTable[0][result.lastPlayedPosition.vertical].win = true;
            gameTable[1][result.lastPlayedPosition.vertical].win = true;
            gameTable[2][result.lastPlayedPosition.vertical].win = true;
          }  else if (result.wonLineType == 'LEFT_DIAMETER') {
            gameTable[0][0].win = true;
            gameTable[1][1].win = true;
            gameTable[2][2].win = true;
          }  else if (result.wonLineType == 'RIGHT_DIAMETER') {
            gameTable[0][2].win = true;
            gameTable[1][1].win = true;
            gameTable[2][0].win = true;
          }
        });
  }


}
