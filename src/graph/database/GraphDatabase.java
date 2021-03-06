/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * class ini berguna untuk menangani objek graph database
 */
public class GraphDatabase {
    // definisikan segala konstanta yang dibutuhkan oleh class graph database disini
    private final String LIST_NODE_FILE_NAME = "data\\list_node";
    private final String LIST_EDGE_FILE_NAME = "data\\list_edge";        
    private final String LIST_GRAPH_ID_FILE_NAME = "data\\list_graph_id";
    private final String LIST_NODE_ID_FILE_NAME = "data\\list_node_id";
    private final String LIST_EDGE_ID_FILE_NAME = "data\\list_edge_id";
    private final String LIST_ID_KEY = "listId";

    private List<Graph> listGraph;
    private List<Long> listIdGraph;
    private List<Long> listIdNode;
    private List<Long> listIdEdge;

    
    /**
     * Default Constructor
     */
    public GraphDatabase(){
        listGraph = new ArrayList<Graph>();
    }
    
    /**
     * Contributor : 
     *  - isjhar kautsar (isjhar@gmail.com)
     * method yang digunakan untuk memasukkan 1 node ke dalam graph database
     * IS : jumlah graph dalam database sebanyak n dan jumlah node sebanyak m
     * FS : jumlah graph dalam database sebanyak n + 1 dan jumlah node sebanyak m + 1
     * @param node node yang akan dimasukkan
     * 
     * generate ada inisiasi id node yang akan di masukkan dilakukan dalam method ini
     */
    public void addNode(Node node) throws IOException, FileNotFoundException, NoSuchElementException, ParseException{
        // buat object graph
        Graph graph = new Graph();
        
        // generate id graph
        graph.setId(generateId(Graph.class));
        
        // genearete id node
        node.setId(generateId(Node.class));
        
        // add node
        graph.addNode(node);
        
        // add to list
        listGraph.add(graph);
    }
    
    /**
     * method yang digunakan untuk menghapus 1 node dari dalam graph database
     * IS : jumlah graph dalam database sebanyak n dan jumlah node sebanyak m
     * FS : node terhapus,
     *  jumlah node menjadi sebanyak m - 1 dan jika graph asal node tersebut membentuk graph baru sebanyak a buah, maka
     *  jumlah graph dalam database sebanyak n + a, dan jika tidak, maka jumlahnya tetap sebanyak n
     * @param node node yang akan dihapus
     */
    public void removeNode(Node node){
        
    }
    
    /**
     * method ini digunakan untuk menambahkan relasi dari antara dua node
     * IS : jumlah graph sebanyak n dan
     *  jumlah elemen pada listEdge yang menjadi source node sebanyak m
     * FS : jika node yang menjadi source dan node yang menjadi destination barada pada dua graph yang berbeda maka
     *  jumlah graph ada sebanyak n - 1, jika tidak maka jumlah graph sebanyak n, dan
     *  jumlah elemen pada listEdge yang menjadi source node sebanyak m + 1
     *  edge yang akan dimasukkan sudah berada dalam listEdge pada source node dan destination node pada edge sudah diset
     * @param source source node
     * @param destination node yang akan dituju
     * @param edge edge yang akan ditambahkan
     * 
     * generate id edge dilakukan di method ini
     */
    public void addRelation(Node nSource, Node nDestination, Edge edge){
             
    }
    
    
    
    /**
     * method ini digunakan untuk menambahkan relasi antar node dengan memperoleh informasi dari JSONObject
     * hasil parse dari file edge
     * IS : edge berupa JSONObject sudah terdefinisi
     * FS : edge yang berupa JSONObject sudah dikonversi menjadi object edge dan telah ditambahkan pada listEdge pada source node
     * @param edge edge yang akan ditambahkan
     */
    public void addRelation(JSONObject edge){
        
    }
    
    
    /**
     * method ini digunakan untuk menghapus edge yang ada pada source node
     * IS : jumlah graph dalam database sebanyak n dan jumlah edge sebanyak m
     * FS : edge pada node source terhapus, jumlah edge menjadi m - 1 dan
     * jika pada saat penghapusan edge terjadi pembentukan graph baru sebanyak a, 
     * maka jumlah graph menjadi n + a
     * @param edge edge yang akan dihapus graph database
     * 
     */
    public void removeRelation(Node source, Edge edge){
        
    }
    
    /**
     * method ini digunakan untuk menyimpan seluruh perubahan data yang terjadi kedalam file.
     * IS : data yang akan disimpan atau diupdate sudah berada pada listGraph
     * FS : data yang ada pada listGraph telah disimpan ke dalam file, 
     *  file yang menyimpan list node, list edge, list id graph, list id node, list id edge terupdate, 
     * 
     * data yang disimpan dan yang diupdate adalah data yang hanya terdapat pada variable listGraph.
     * ingat! 1 graph akan disimpan pada minimal 2 file, yaitu 1 file untuk menyimpan kumpulan node 
     * yang ada pada graph tersebut dan 1 file untuk menyimpan kumpulan edge yg ada. 
     * jika jumlah node atau edge yang akan disimpan lebih dari 50, maka simpan pada file yang terpisah. 
     * selalu cek dulu apakah graph yang akan diupdate sudah pernah ditulis pada file atau belum.
     * jika sudah, berarti hapus semua file yang lama dahulu sebelum tulis file yang baru
     * selalu simpan nama file pada file yang menyimpan list file yang ada dengan kondisi terurut secara ascending
     */
    public void commit(){
        
    }

    /**
     * method ini digunakan untuk mencari node dalam graph database berdasarkan id
     * IS : id yang akan dicari telah didefinisikan, listGraph kemungkinan kosong
     * FS : graph yang telah di-retrieve dari hard disk karena proses pencari akan disimpan ke dalam listGraph dan
     *  jika data tidak ditemukan maka method ini akan mengembalikan null, 
     *  dan jika data ditemukan maka method ini akan mengembalikan Node tersebut
     * @param id id node yang akan dicari
     * @return Object node yang akan dicari
     * 
     * pencarian dilakukan terlebih dahulu dilakukan di cek di memori, yaitu di cek pada variable listGraph
     * jika ada, maka outputkan nodenya
     * jika tidak ada, maka cari di hardisk
     * telusuri data per graph 
     */
    public Node findNodeById(long id){
        Node result = null;
        return result;
    }
    
    /**
     * method ini digunakan untuk mencari node dalam graph database berdasarkan properties
     * IS : proerties yang akan dicari telah didefinisikan, listGraph kemungkinan kosong
     * FS : graph yang telah di-retrieve dari hard disk karena proses pencari akan disimpan ke dalam listGraph dan
     *  jika data tidak ditemukan maka method ini akan mengembalikan null, 
     *  dan jika ada data yang ditemukan maka method ini akan mengembalikan List<Node> tersebut
     * @param properties daftar properties yang akan dicocokkan dengan data yang ada
     * @return list dari node yang ditemukan
     * 
     * pencarian dilakukan dengan menelusuri seluruh graph tetapi
     * pencarian dilakukan terlebih dahulu dilakukan di cek di memori, yaitu di cek pada variable listGraph
     * setelah itu, lalu retrieve yang belum di retrieve     
     */
    public List<Node> findNodeByProperties(HashMap<String, Property> properties){
        List<Node> result = null;
        return result;
    }
    
    /**
     * method ini digunakan untuk mencari node dalam graph database berdasarkan label
     * IS : label yang akan dicari telah didefinisikan, listGraph kemungkinan kosong
     * FS : graph yang telah di-retrieve dari hard disk karena proses pencari akan disimpan ke dalam listGraph dan
     *  jika data tidak ditemukan maka method ini akan mengembalikan null, 
     *  dan jika ada data yang ditemukan maka method ini akan mengembalikan List<Node> tersebut
     * @param label label yang akan dicocokkan dengan data yang ada
     * @return list dari node yang ditemukan
     * 
     * pencarian dilakukan dengan menelusuri seluruh graph tetapi
     * pencarian dilakukan terlebih dahulu dilakukan di cek di memori, yaitu di cek pada variable listGraph
     * setelah itu, lalu retrieve yang belum di retrieve
     */
    public List<Node> findNodeByLabel(String label){
        List<Node> result = null;
        return result;
    }
    
    /**
     * method ini digunakan untuk me-retrieve data graph dari hard disk ke memory
     * @param fileName nama file yang akan diretrieve
     * @return graph yang sesuai dengan nama file
     * 
     * format nama file yang digunakan untuk node : graph_(id_graph)_(no_partisi)_node 
     * format nama file yang digunakan untuk edge : graph_(id_graph)_(no_partisi)_edge
     * format yang di pass pada parameter cukup : graph_(id_graph)
     */
    public Graph getGraph(String fileName){
        Graph result = null;
        return result;
    }
    
    /**
     * method ini digunakan untuk generate id graph, node, atau edge
     * @param type type Graph, Node, atau Edge
     * 
     * pencarian id yang tersedia dilakukan melalui pengecekan pada memori terlebih dahulu lalu pada hard disk
     */
    private long generateId(Class<?> type) throws FileNotFoundException, IOException, NoSuchElementException, ParseException {
        long id = -1;
        long count = 0;
        JSONObject obj;
        JSONArray listId;
        Iterator<?> iterator;
        String pathFile;
        if (type == Edge.class) {
            if (listIdEdge == null) {
                // sinkronisasi start
                listIdEdge = new ArrayList<Long>();
                FileReader reader = new FileReader(LIST_EDGE_FILE_NAME);
                JSONParser parser = new JSONParser();
                BufferedReader br = new BufferedReader(reader);

                obj = (JSONObject) parser.parse(reader);
                listId = (JSONArray) obj.get(LIST_ID_KEY);
                iterator = listId.iterator();
                while (iterator.hasNext()) {
                    listIdEdge.add(Long.parseLong(iterator.next().toString().replaceAll("[a-zA-Z]+", "")));
                }
                // sinkronisasi end
                
                for (long i : listIdEdge) {
                    if (i != count) {
                        break;
                    }
                    count++;
                }
                id = count;
            } else {
                for (long i : listIdEdge) {
                    if (i != count) {
                        break;
                    }
                    count++;
                }
                id = count;
            }
        } else if (type == Node.class) {
            if (listIdNode == null) {
                // sinkronisasi start
                listIdNode = new ArrayList<Long>();
                FileReader reader = new FileReader(LIST_NODE_ID_FILE_NAME);
                JSONParser parser = new JSONParser();
                BufferedReader br = new BufferedReader(reader);

                obj = (JSONObject) parser.parse(reader);
                listId = (JSONArray) obj.get(LIST_ID_KEY);
                iterator = listId.iterator();
                while (iterator.hasNext()) {
                    listIdNode.add(Long.parseLong(iterator.next().toString().replaceAll("[a-zA-Z]+", "")));
                }
                // sinkronisasi end
                for (long i : listIdNode) {
                    if (i != count) {
                        break;
                    }
                    count++;
                }
                id = count;
            } else {
                for (long i : listIdNode) {
                    if (i != count) {
                        break;
                    }
                    count++;
                }
                id = count;
            }
        } else if (type == Graph.class) {
            if (listIdGraph == null) {
                // sinkronisasi start
                listIdGraph = new ArrayList<Long>();
                FileReader reader = new FileReader(LIST_GRAPH_ID_FILE_NAME);
                JSONParser parser = new JSONParser();
                BufferedReader br = new BufferedReader(reader);

                obj = (JSONObject) parser.parse(reader);
                listId = (JSONArray) obj.get(LIST_ID_KEY);
                iterator = listId.iterator();
                while (iterator.hasNext()) {
                    listIdGraph.add(Long.parseLong(iterator.next().toString().replaceAll("[a-zA-Z]+", "")));
                }
                // sinkronisasi end
                for (long i : listIdGraph) {
                    if (i != count) {
                        break;
                    }
                    count++;
                }
                id = count;
            } else {
                for (long i : listIdGraph) {
                    if (i != count) {
                        break;
                    }
                    count++;
                }
                id = count;
            }
        } else {
            throw new NoSuchElementException("salah pemilihan type yang akan di generate id-nya");
        }
        return id;
    }

    
    /**
     * method ini digunakan untuk mencari graph yang terbentuk dalam sebuah graph.
     * graph dalam graph bakal terjadi ketika proses penghapusan node atau edge dilakukan
     * @param graph graph yang akan di cari jumlah graph yang telah terpisah
     * @return kumpulan graph yang ditemukan
     */
    public List<Graph> findSeparatedGraph(Graph graph){
        List<Graph> result = null;
        return result;
    }
}
