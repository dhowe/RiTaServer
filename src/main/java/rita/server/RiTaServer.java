package rita.server;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class RiTaServer
{
  // Base URI the Grizzly HTTP server will listen on
  public static final String BASE_URI = "http://144.214.223.68:8094/rita/";

  /**
   * Starts Grizzly HTTP server exposing JAX-RS resources defined in rita.remote
   */
  public static HttpServer createServer()
  {
    // create a resource config that scans for JAX-RS resources and providers
    // in rita.remote package, then start a new instance of grizzly http server
    final ResourceConfig rc = new ResourceConfig();
    rc.packages(false, "rita.remote");
    return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
  }

  public static void main(String[] args) throws Exception
  {
    final HttpServer server = createServer();
    System.out.println(String.format("Jersey app started with WADL available at "
        + "%sapplication.wadl...", BASE_URI));

    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
    {
      public void run()
      {
        System.out.println("Stopping server..");
        server.shutdownNow();
      }
    }, "shutdownHook"));

    server.start();
    Thread.currentThread().join();
  }
}
