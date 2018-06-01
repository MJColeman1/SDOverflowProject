import { Category } from './category';
import { Pipe, PipeTransform } from '@angular/core';
import { Post } from './post';

@Pipe({
  name: 'categoryType'
})
export class CategoryTypePipe implements PipeTransform {

  transform(posts: Post[], category?: Category): any {
    const results = [];

    if (category.name === 'all') {
      return posts;
    }

    posts.forEach(post => {
      if (post.category.name === category.name) {
        results.push(post);
      }
    });
    return null;
  }

}
