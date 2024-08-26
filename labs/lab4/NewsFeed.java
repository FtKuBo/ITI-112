/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

	private Post[] messages;
	private int size;
	public static final int MAX_SIZE = 25;

	public NewsFeed() {
		this.messages = new Post[MAX_SIZE];
		this.size = 0;
	}

	public void add(Post message) {
		if (size >= MAX_SIZE - 1) {
			System.out.println("You have reached the maximum amount of messages that we can store");
		} else {
			this.messages[size] = message;
			size++;
		}
	}

	public Post get(int index) {
		return messages[index];
	}

	public int size() {
		return size;
	}

	public void sort() {
		int i, j, argMin;
		Post tmp;
		for (i = 0; i < size - 1; i++) {
			argMin = i;
			for (j = i + 1; j < size(); j++) {
				if (messages[j].compareTo(messages[argMin]) < 0) {
					argMin = j;
				}
			}

			tmp = messages[argMin];
			messages[argMin] = messages[i];
			messages[i] = tmp;
		}

	}

	public NewsFeed getPhotoPost() {
		NewsFeed newfeed = new NewsFeed();
		for (int i = 0; i < size; i++) {
			if (this.messages[i] instanceof PhotoPost) {
				newfeed.add(this.messages[i]);
			}
		}
		return newfeed;
	}

	public NewsFeed plus(NewsFeed other) {
		if (other.size() + this.size() >= MAX_SIZE) {
			System.out.println("you can't merge theis two feeds, the sizes can't be handled");
			return null;
		}

		else {
			NewsFeed newfeed = new NewsFeed();
			for (int i = 0; i < this.size(); i++) {
				newfeed.messages[i] = this.messages[i];
				newfeed.size++;
			}
			for (int y = 0; y < other.size(); y++) {
				newfeed.messages[y + this.size()] = other.messages[y];
				newfeed.size++;
			}
			newfeed.sort();
			return newfeed;

		}
	}

}
