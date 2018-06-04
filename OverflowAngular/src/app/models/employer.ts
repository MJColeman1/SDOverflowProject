import { Technology } from './technology';
import { Address } from './address';

export class Employer {
  id: number;
  name: string;
  hiring: string;
  address: Address;
  technologies: Technology[];

  constructor () {}
}
