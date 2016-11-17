import {RightHolder} from "../statement-details/right-holder/right-holder.model";
export class Statement {
  id: number;
  lastActivityDate: string;
  status: string;
  title: string;
  producerOwnerId: number;
  hasNoArtworks:boolean;
  rightHolders: RightHolder[]

}
