package src;

import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;
import java.util.*;

public class _DirectedWeightedGraph implements DirectedWeightedGraph {



    public HashMap<Integer,NodeData> g ;                  //  Nodes hashmap<int,NodeData>
    private HashMap<Integer,HashMap<Integer,EdgeData>> e; //  Edges hashmap<int,HashMap<int,EdgeData>>


    public ArrayList<EdgeData> ItHelper2;







    protected static int ModeCaunt;
    private static int NC; //nodes caunt we have static method too doesnt metter
    private static int EC; //edge caunt


    public _DirectedWeightedGraph() {
     e = new HashMap<Integer,HashMap<Integer,EdgeData>>();
     g = new HashMap<Integer,NodeData>();
     ItHelper2 = new ArrayList<>();

    }
    public  _DirectedWeightedGraph(_DirectedWeightedGraph o){
        ModeCaunt=o.getMC();
        NC = o.nodeSize();
        EC = o.edgeSize();
        this.e = new HashMap<Integer,HashMap<Integer,EdgeData>>(o.e);//might not work
        this.g = new HashMap<Integer,NodeData>(o.g);
        this.ItHelper2 = new ArrayList<>(o.ItHelper2);



    }

    @Override

    public NodeData getNode(int key) {
        return this.g.get(key);//if doesnt exist hashmapwill drow exeption
    }
    @Override
    public EdgeData getEdge(int src, int dest) { //mahzirim mazbia le Edge
       EdgeData lookingFor;
       if(!e.containsKey(src)){
           return null;
       }
       lookingFor = e.get(src).get(dest);
       return  lookingFor;
    }

    @Override
    public void addNode(NodeData n) { //maby key to obj not allowed much
        g.put(n.getKey(),n);
        NC++;
        ModeCaunt++;
    }

    @Override
    public void connect(int src, int dest, double w) {
        EdgeData p1 = new _EdgeData(src,dest,w);


        if (e.containsKey(src)){
            e.get(src).put(dest,p1);
            ItHelper2.add(p1);
        }else{
            e.put(src,new HashMap<Integer,EdgeData>());
            e.get(src).put(dest,p1);
            ItHelper2.add(p1);

        }



    }



    @Override
    public Iterator<NodeData> nodeIter() {

        return g.values().iterator();
    }





    @Override
    public Iterator<EdgeData> edgeIter() {

        return ItHelper2.iterator();

    }
    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        Iterator<EdgeData> HashMapDestIter_EdgeData = e.get(node_id).values().iterator();
        return HashMapDestIter_EdgeData;
    }


    @Override
    public NodeData removeNode(int key) {
        NodeData r = getNode(key);
        g.remove(key);
        ModeCaunt++;
        e.get(key).clear();
        return r;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        EdgeData edge = e.get(src).get(dest);
        e.get(src).remove(dest);
        ModeCaunt++;
        return edge;
    }




    @Override
    public int nodeSize() {
        return NC;
    }

    @Override
    public int edgeSize() {
        return EC;
    }

    @Override
    public int getMC() {
        return ModeCaunt;
    }


    public void PrintNodeGraph () {
        Iterator<NodeData> aaaaaaaa = nodeIter();
        while (aaaaaaaa.hasNext()){
            System.out.println(aaaaaaaa.next()+",");
        }
    }



}
    /**this filds and constructor for dwg obj and graph **/



