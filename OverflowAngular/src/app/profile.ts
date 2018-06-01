import { Technology } from './technology';
import { Employer } from './employer';
import { Address } from './address';

export class Profile {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  cohort: string;
  employed: boolean;
  address: Address;
  employer: Employer;
  technologies: Technology[];
}
