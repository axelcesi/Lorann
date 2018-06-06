package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <h1>The Lorann BDDConnector</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

final class LorannBDDConnector {

    /** The instance. */
    private static LorannBDDConnector instance;

    /** The login. */
    private static String                  user     = "java";

    /** The password. */
    private static String                  password = "java";

    /** The url. */
    private static String                  url      = "jdbc:mysql://localhost/lorann?useSSL=false&serverTimezone=UTC";

    /** The connection. */
    private Connection                     connection;

    /** The statement. */
    private Statement                      statement;

    /** Instantiates a new Lorann BDD connector. */
    LorannBDDConnector() {
        this.open();
    }

    /**
     * Gets the single instance of Lorann BDDConnector.
     *
     * @return single instance of Lorann BDDConnector.
     */
    public static LorannBDDConnector getInstance() {
        if (instance == null) {
            setInstance(new LorannBDDConnector());
        }
        return instance;
    }

    /**
     * Sets the instance.
     *
     * @param instance
     *            the new instance
     */
    private static void setInstance(final LorannBDDConnector instance) {
        LorannBDDConnector.instance = instance;
    }

    /**
     * Open.
     *
     * @return true, if successful
     */
    private boolean open() {
        try {
            this.connection = DriverManager.getConnection(LorannBDDConnector.url, LorannBDDConnector.user,
                    LorannBDDConnector.password);
            this.statement = this.connection.createStatement();
            return true;
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    /**
     * Execute query.
     *
     * @param query
     *            the query
     * @return the result set
     */
    public ResultSet executeQuery(final String query) {
        try {
            return this.getStatement().executeQuery(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Prepare call.
     *
     * @param query
     *            the query
     * @return the java.sql. callable statement
     */
    public java.sql.CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Execute update.
     *
     * @param query
     *            the query
     * @return the int
     */
    public int executeUpdate(final String query) {
        try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Sets the connection.
     *
     * @param connection
     *            the new connection
     */
    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    /**
     * Gets the statement.
     *
     * @return the statement
     */
    public Statement getStatement() {
        return this.statement;
    }

    /**
     * Sets the statement.
     *
     * @param statement
     *            the new statement
     */
    public void setStatement(final Statement statement) {
        this.statement = statement;
    }

    /**
     * 
     * @param level
     * @return resultSet String
     * @throws SQLException
     */
    public String getResult(int level) throws SQLException
    {
    	//final java.sql.CallableStatement callStatement = prepareCall("{call query_level(" + level + ")}");
    	//return callStatement.getResultSet().getString(2);
    	String url = "jdbc:mysql://localhost/lorann?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String login = "java";
        String passwd = "java";
        Connection cn =null;
        Statement st =null;
        ResultSet rs =null;
        String test = "";
       
        try {

            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);

            // Etape 3 : Création d'un statement
            st = cn.createStatement();

            String sql = "{call query_level("+level+")}";
            java.sql.CallableStatement statement = cn.prepareCall(sql);

            // Etape 4 : exécution requête
            rs = st.executeQuery(sql);

            // Si récup données alors étapes 5 (parcours Resultset)

            while (rs.next()) {
                test = rs.getString("Level_Code");
                //System.out.println(test);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
            // Etape 6 : libérer ressources de la mémoire.
                cn.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return test;
    }
}
