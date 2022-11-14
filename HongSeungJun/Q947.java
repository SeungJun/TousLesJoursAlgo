import java.util.HashSet;

public class Q947 {
    class UnionFind{
        final int N = 20001;
        int rank[]=new int[N],parn[]=new int[N];
        // union할 때 크기를 비교할 rank와 union 배열 parn 각각 초기화
        void makeSet(){
            for(int i=0;i<N;i++){
                rank[i]=0;
                parn[i]=i;
            }
        }
        // 재귀를 이용해 부모를 찾는다.
        // 부모를 찾는다는것은 그래프가 연결되어있는지 확인하는것
        int findParent(int nd){
            if(nd==parn[nd])
                return nd;
            return parn[nd]=findParent(parn[nd]);
        }
        // 두개의 노드를 연결한다.
        void unionSet(int a, int b){
            int pa=findParent(a),pb=findParent(b);
            if(rank[pa]==rank[pb]){
                rank[pa]++;
                parn[pb]=pa;
            }else if(rank[pa]<rank[pb])
                parn[pa]=pb;
            else parn[pb]=pa;
        }
        UnionFind() {makeSet();}
    }

    public int removeStones(int[][] stones) {
        UnionFind ob = new UnionFind();
        for(int[] coor: stones){
            if(ob.findParent(coor[0]) != ob.findParent(coor[1]+10000))
                ob.unionSet(coor[0],coor[1]+10000);
        }
        // 중복을 확인 하기 위하여 HashSet을 확인
        HashSet<Integer> set = new HashSet<Integer>();
        int stonesLeft=0;
        for(int[] coor: stones){
            if(!set.contains(ob.findParent(coor[0]))){
                set.add(ob.findParent(coor[0]));
                stonesLeft++;
            }
        }
        return stones.length-stonesLeft;
    }
}
