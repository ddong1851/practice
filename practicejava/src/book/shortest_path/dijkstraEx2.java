package src.book.shortest_path;

import java.util.*;

class Node2 implements Comparable<Node2> {

    private int index;
    private int distance;

    public Node2(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 嫄곕━(鍮꾩슜)媛� 吏㏃� 寃껋씠 �넂�� �슦�꽑�닚�쐞瑜� 媛�吏��룄濡� �꽕�젙
    @Override
    public int compareTo(Node2 other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class dijkstraEx2 {

    public static final int INF = (int) 1e9; // 臾댄븳�쓣 �쓽誘명븯�뒗 媛믪쑝濡� 10�뼲�쓣 �꽕�젙
    // �끂�뱶�쓽 媛쒖닔(N), 媛꾩꽑�쓽 媛쒖닔(M), �떆�옉 �끂�뱶 踰덊샇(Start)
    // �끂�뱶�쓽 媛쒖닔�뒗 理쒕� 100,000媛쒕씪怨� 媛��젙
    public static int n, m, start;
    // 媛� �끂�뱶�뿉 �뿰寃곕릺�뼱 �엳�뒗 �끂�뱶�뿉 ���븳 �젙蹂대�� �떞�뒗 諛곗뿴
    public static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();
    // 理쒕떒 嫄곕━ �뀒�씠釉� 留뚮뱾湲�
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        // �떆�옉 �끂�뱶濡� 媛�湲� �쐞�븳 理쒕떒 寃쎈줈�뒗 0�쑝濡� �꽕�젙�븯�뿬, �걧�뿉 �궫�엯
        pq.offer(new Node2(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) { // �걧媛� 鍮꾩뼱�엳吏� �븡�떎硫�
            // 媛��옣 理쒕떒 嫄곕━媛� 吏㏃� �끂�뱶�뿉 ���븳 �젙蹂� 爰쇰궡湲�
            Node2 node = pq.poll();
            int dist = node.getDistance(); // �쁽�옱 �끂�뱶源뚯��쓽 鍮꾩슜 
            int now = node.getIndex(); // �쁽�옱 �끂�뱶
            // �쁽�옱 �끂�뱶媛� �씠誘� 泥섎━�맂 �쟻�씠 �엳�뒗 �끂�뱶�씪硫� 臾댁떆
            if (d[now] < dist) continue;
            // �쁽�옱 �끂�뱶�� �뿰寃곕맂 �떎瑜� �씤�젒�븳 �끂�뱶�뱾�쓣 �솗�씤
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // �쁽�옱 �끂�뱶瑜� 嫄곗퀜�꽌, �떎瑜� �끂�뱶濡� �씠�룞�븯�뒗 嫄곕━媛� �뜑 吏㏃� 寃쎌슦
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node2(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 洹몃옒�봽 珥덇린�솕
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node2>());
        }
        
        // 紐⑤뱺 媛꾩꽑 �젙蹂대�� �엯�젰諛쏄린
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a踰� �끂�뱶�뿉�꽌 b踰� �끂�뱶濡� 媛��뒗 鍮꾩슜�씠 c�씪�뒗 �쓽誘�
            graph.get(a).add(new Node2(b, c));
        }
        sc.close();

        // 理쒕떒 嫄곕━ �뀒�씠釉붿쓣 紐⑤몢 臾댄븳�쑝濡� 珥덇린�솕
        Arrays.fill(d, INF);
        
        // �떎�씡�뒪�듃�씪 �븣怨좊━利섏쓣 �닔�뻾
        dijkstra(start);

        // 紐⑤뱺 �끂�뱶濡� 媛�湲� �쐞�븳 理쒕떒 嫄�6由щ�� 異쒕젰
        for (int i = 1; i <= n; i++) {
            // �룄�떖�븷 �닔 �뾾�뒗 寃쎌슦, 臾댄븳(INFINITY)�씠�씪怨� 異쒕젰
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // �룄�떖�븷 �닔 �엳�뒗 寃쎌슦 嫄곕━瑜� 異쒕젰
            else {
                System.out.println(d[i]);
            }
        }
    }
}