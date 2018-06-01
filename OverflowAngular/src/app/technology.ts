import { Profile } from './profile';
import { Employer } from './employer';

export class Technology {
  id: number;
  name: string;
  description: string;
  payscale: string;
  profiles: Profile[];
  employers: Employer[];
}
