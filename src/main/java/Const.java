public enum Const {
    URL("netology.homework"),
    PORT(3000),
    ;


    private String url;
    private int port;

    Const(String url) {
        this.url = url;
    }

    Const(int port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}