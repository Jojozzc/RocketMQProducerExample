public class ServerConfig {
    public static final String NAMESVR_IP = "127.0.0.1";
    public static final String REMOTE_NAMESVR_IP = "39.106.55.43";
    public static final int NAMESVR_PORT = 9876;
    public static String getNamesvrURL(){
        return REMOTE_NAMESVR_IP + ':' + NAMESVR_PORT;
    }
}
