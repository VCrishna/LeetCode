class Twitter {
    // User - follower list
    // userid, followers set
    // Map<User, Set<Users>>
    Map<Integer, Set<Integer>> users;
    // userid, List[timestamp, tweet]
    // Map<Integer, List<int[]> tweetMap;
    Map<Integer, List<int[]>> tweetMap;
    int time;

    public Twitter() {
        users = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        // creating new tweet object, incrementing time for each new tweet
        int[] tweet = new int[] { time++, tweetId };
        // checking if userId is not present in the tweetMap
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        // adding tweet to the specific user
        tweetMap.get(userId).add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        // getting all the user followers
        Set<Integer> followers = users.getOrDefault(userId, new HashSet<>());
        // as we also want to show user tweets as well so we are adding userId into the set
        followers.add(userId);
        // maxHeap 
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // adding tweets of each user into the priorityqueue
        for (int user : followers) {
            if (tweetMap.containsKey(user)) {
                tweetMap.get(user).forEach(x -> maxHeap.offer(x));
            }
        }

        // Populate feed with top 10 posts
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            feed.add(maxHeap.poll()[1]);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new HashSet<>());
        }
        users.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) 
            users.get(followerId).remove(followeeId);
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
