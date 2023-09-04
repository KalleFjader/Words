import java.util.*;

public class Graph {
    private int temp1;
    private int temp2;

    ArrayList<Node> NodeList = new ArrayList<>();
    ArrayList<Node> sortedList = new ArrayList<>();

    public String[] listCreator(){  //Skapar en lista med ord
        String[] words = new String[] {"vacs" , "vade" , "vaes" , "vagi" , "vags" , "vail" , "vain" , "vair" , "vale" , "vali" , "vamp" , "vane" , "vang" , "vans" , "vant" , "vara" , "vare" , "vars" , "vary" , "vasa" , "vase" , "vast" , "vats" , "vatu" , "vaus" , "vaut" , "vavs" , "vaws" , "veal" , "veep" , "veer" , "vees" , "vega" , "vego" , "vehm" , "veil" , "vein" , "vela" , "veld" , "vele" , "vell" , "vena" , "vend" , "vent" , "vera" , "verb" , "verd" , "vers" , "vert" , "very" , "vest" , "veto" , "vets" , "vext" , "viae" , "vial" , "vias" , "vibe" , "vibs" , "vice" , "vide" , "vids" , "vied" , "vier" , "vies" , "view" , "viga" , "vigs" , "vild" , "vile" , "vill" , "vims" , "vina" , "vine" , "vino" , "vins" , "vint" , "viny" , "viol" , "vire" , "virl" , "visa" , "vise" , "vita" , "vite" , "viva" , "vive" , "vivo" , "vizy" , "vlei" , "voar" , "voes" , "void" , "vola" , "vole" , "volk" , "vols" , "volt" , "vors" , "vote" , "vows" , "vril" , "vrot" , "vrou" , "vrow" , "vugg" , "vugh" , "vugs" , "vuln" , "vums"};
        return words;
    }

    public void addNodes(String[] ord){     //Skapar en lista med noder
        for(String i : ord){
            Node newNode = new Node();
            newNode.word = i;
            newNode.dist = 1000;
            NodeList.add(newNode);
        }
            for(String k : ord){
                for(String j : ord){
                    if(differsWithOne(k,j) && !k.equals(j)){  //ifall ett ord bara skiljer sig med en bokstav från ett annat skapar en bro
                        addBridge(k, j);
                    }
                }
            }
    }
    public void addBridge(String word1, String word2){  //skapar en bro mellan två noder
        int i;
        for (i = 0; i < NodeList.size(); i++) {
            if (NodeList.get(i).word == word1) {
                temp1 = i;
            }
        }
        int j;
        for (j = 0; j < NodeList.size(); j++) {
            if (NodeList.get(j).word == word2) {
                temp2 = j;
            }
        }
        NodeList.get(temp1).neighbour.add(NodeList.get(temp2));
    }

    static boolean differsWithOne(String word1, String word2) {  //kollar ifall de två orden endast har en bokstavs skillnad
        int lettersThatDiffer = 1;
            for(int i = 0; i < word1.length(); i++) {
                if(word1.charAt(i) != word2.charAt(i)) {
                    lettersThatDiffer--;
                    if(lettersThatDiffer < 0) {
                        return false;
                    }
                }
            }
        return true;
    }

    public void djikstras(Node s){    //sorterar grafen
        Node v;
        s.dist = 0;
        for(; ;){
            v = getSmallestDist(NodeList);
            NodeList.remove(v);
        if(v == null){
            break;
        }
                v.known = true;
                sortedList.add(v);
                for(Node w : v.neighbour){
                    if(!w.known){
                        if(v.dist + 1 < w.dist){
                            w.dist = v.dist + 1;
                            w.path = v;
                        }
                    }

                }

            }
        }

    public Node getSmallestDist(ArrayList<Node> graph) {   //returnerar den nod men lägsta distansen till startnoden
        for (Node q : graph) {
            if (isItsmallestDist(q, graph) && !q.known) {
                return q;
            }
        }
        return null;
    }

    public boolean isItsmallestDist(Node v, ArrayList<Node> graf) {   //returnerar true ifall den angivna noden har minst distans
        for (Node k : graf){
            if (v.dist > k.dist){
                return false;
            }
        }
        return true;
    }

    public int getPosition(String ord, ArrayList<Node> graph){   //returnerar positionen i listan "graph" där nodens ord = parametern "ord"
        int counter = 0;
        for (Node q : graph) {
            counter++;
            if(Objects.equals(ord, q.word)){
                return counter-1;
            }
        }
        return -1;
    }

    public void printPath(Node v){   //printar ut kortaste vägen i konsolen
        if(v.path != null){
            printPath(v.path);
            System.out.print(" to ");
        }
        System.out.print(v.word);
    }
    }

