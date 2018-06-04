import { Post } from './post';
import { Comment } from './comment';
import { Profile } from './profile';

export class User {
  id: number;
  username: string;
  password: string;
  role: string;
  enabled: boolean;
  admin: boolean;
  profile: Profile;
  comments: Comment[];
  posts: Post[];

  constructor () {
    this.profile = new Profile();
    this.comments = [];
    this.posts = [];
  }
}
