public class Graphnode {
        public String name;
        public int index;
        public boolean isVisited = false;
        public Graphnode parent;
        public Graphnode(String name,int index){
            this.name = name;
            this.index = index;
        }
    }

