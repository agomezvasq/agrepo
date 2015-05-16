class GraphNd {
    public GraphNd [] node;
    public Typ type;

    enum Typ {
        NODE,
        OBSTACLE,
        DRONE
    };

    public Tree4N(Typ type) {
        this.nodes = new Tree4N[4];
        this.type = Typ.NODE;
    }

    //0:down 1:up 2:left 3:right
}
