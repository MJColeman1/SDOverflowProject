import { Comment } from './comment';
import { User } from './user';
import { Category } from './category';

export class Post {
  id: number;
  name: string;
  description: string;
  createdAt: string;
  updatedAt: string;
  category: Category;
  user: User;
  comments: Comment[];

  constructor () {}
}
