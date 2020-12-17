export interface ApiResponse<T> {
	data : T;
	success : boolean;
	error : string;
}

export interface PlayerModel {
	name : string;
	uuid: string;
}

export interface BoardPositionModel {
	vertical : number;
	horizontal : number;
	checked : boolean;
	player : PlayerModel;
}

export interface Position {
	vertical : number;
	horizontal : number;
}

export interface GameResult {
	winner : string;
	wonLineType : string;
	lastPlayedPosition : Position;
	gameStatus : string;
}

export interface PickBoxAction {
	playerUuid : string;
	gameUuid : string;
	vertical : number;
	horizontal : number;
}

export interface GameModel {
	uuid : string;
	firstPlayer : PlayerModel;
	secondPlayer : PlayerModel;
	boardPositions : BoardPositionModel[];
}