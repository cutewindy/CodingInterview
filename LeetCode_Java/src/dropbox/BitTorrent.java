package dropbox;


//import Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给一堆Chunk和一个file size,问给定的一堆Chunk能不能组成complete file.
//Chunk就是一个左开右闭的区间, 如[0, 4)表示这个chunk包含0, 1, 2, 3这4个byte. 给定的size是这个文件大小.
//boolean isCompleteFile(List<Chunk> chunks, int size)
//例如:.
//chunks = [[0, 1), [1, 3), [3, 4)]  size = 4   => 结果是true
//chunks = [[0, 1), [1, 3), [3, 4)]  size = 5   => 结果是false
//chunks = [[0, 1), [2, 3), [3, 4)]  size = 4   => 结果是false.1point3acres缃�
//.2. 实现一个ChunkManager class, 实现一个函数, isCompleteForNow(Chunk chunk), 每call一次这个函数,就会把chunk更新到这个类中,并判断当前类中已经有的list of chunk可不可以组成一个complete file..1point3acres缃�
//例如:
//ChunkManager chunkManager = new ChunkManager(4);
//chunkManager.isCompleteForNow([0, 2)); -> false
//chunkManager.isCompleteForNow([2, 3)); -> true
//
//followup是建一个class接收one block at a time，所以不是一下子拿到所有的chunk让你来比较，自己定一个data structure来存chunks。
//class Downloader {
//    public Downloader(int size) {
//    // save size somewhere  }. 1point3acres
//
//  public void addBlock(Range r) {
//    // TODO: implement   }
//
//  public boolean isDone() {
//    // TODO: implement   }
//}

/* bitset -> balanced BST
 * 
 * @author wendi
 *
 */
public class BitTorrent {
	
	
	/**
	 * follow up
	 * @param intervals
	 * @param newInterval
	 * @return
	 * Time: O(n)
	 * Space: O(n)
	public List<Interval> insertIntervalI(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) return intervals;
        List<Interval> res = new ArrayList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        res.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
	}

	
	/**
	 * list sort
	 * @param intervals
	 * @return
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
    public List<Interval> mergeInterval(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start != b.start) return a.start - b.start;
                return a.end - b.end;
            }
        });
        Interval curr = intervals.get(0);
        for (Interval next: intervals) {
            if (next.start <= curr.end) {
                curr.end = Math.max(curr.end, next.end);
            }
            else {
                res.add(curr);
                curr = next;
            }
        }
        res.add(curr);
        return res;
    }	
    
    class Interval{
    	int start;
    	int end;
    	public Interval(int start, int end) {
    		this.start = start;
    		this.end = end;
    	}
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
