import { User } from './user';
import { Post } from './post';

export class Comment {
  id: number;
  description: string;
  createdAt: string;
  updatedAt: string;
  post: Post;
  user: User;

  constructor () {}
}
