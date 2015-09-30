package rita.remote;

import javax.ws.rs.*;

import rita.RiWordNet;

@Path("remote/json/RiWordNet")
public class RiWordNetRemoteJSON extends RiTaRemote
{
  private static RiWordNet wordnet;

  @GET
  @Path("getAllCoordinates/")
  @Produces("text/html")
  public String getAllCoordinates(@QueryParam("query") String query, @QueryParam("pos") String pos)
  {
    String[] result = null;
    try
    {
      result = getRiWordNet().getAllCoordinates(query, pos);
    }
    catch (Exception e)
    {
      return toJSON(e);
    } 

    return toJSON(result);
  }
  
  @GET
  @Path("getAllSynonyms/")
  @Produces("text/html")
  public String getAllSynonyms(@QueryParam("query") String query, @QueryParam("pos") String pos)
  {
    String[] result = null;
    try
    {
      result = getRiWordNet().getAllSynonyms(query, pos);
    }
    catch (Exception e)
    {
      return toJSON(e);
    }

    return toJSON(result);
  }
  
  @GET
  @Path("getAllDerivedTerms/")
  @Produces("text/html")
  public String getAllDerivedTerms(@QueryParam("query") String query, @QueryParam("pos") String pos)
  {
    String[] result = null;
    try
    {
      result = getRiWordNet().getAllDerivedTerms(query, pos);
    }
    catch (Exception e)
    {
      return toJSON(e);
    }

    return toJSON(result);
  }

  // Boolean --------------------------------------------------------

  @GET
  @Path("isVerb/")
  @Produces("text/html")
  public String isVerb(@QueryParam("query") String query)
  {
    try
    {
      boolean result = getRiWordNet().isVerb(query);
      // System.out.println(query+" -> "+verb);
      return toJSON(result);
    }
    catch (Exception e)
    {
      return toJSON(e);
    }
  }

  @GET
  @Path("isAdjective/")
  @Produces("text/html")
  public String isAdjective(@QueryParam("query") String query)
  {
    try
    {
      boolean result = getRiWordNet().isAdjective(query);
      // System.out.println(query+" -> "+verb);
      return toJSON(result);
    }
    catch (Exception e)
    {
      return toJSON(e);
    }
  }

  @GET
  @Path("isNoun/")
  @Produces("text/html")
  public String isNoun(@QueryParam("query") String query)
  {
    try
    {
      boolean result = getRiWordNet().isNoun(query);
      // System.out.println(query+" -> "+verb);
      return toJSON(result);
    }
    catch (Exception e)
    {
      return toJSON(e);
    }
  }

  @GET
  @Path("isAdverb/")
  @Produces("text/html")
  public String isAdverb(@QueryParam("query") String query)
  {
    try
    {
      boolean result = getRiWordNet().isAdverb(query);
      // System.out.println(query+" -> "+verb);
      return toJSON(result);
    }
    catch (Exception e)
    {
      return toJSON(e);
    }
  }
  
  @GET
  @Path("exists/")
  @Produces("text/html")
  public String exists(@QueryParam("callback") String callback, @QueryParam("query") String query)
  {
    try
    {
      boolean result = getRiWordNet().exists(query);
      // System.out.println(query+" -> "+verb);
      return toJSON(result);
    }
    catch (Exception e)
    {
      return toJSON(e);
    }
  }
  
  // Helpers --------------------------------------------------------

  protected RiWordNet getRiWordNet()
  {
    if (wordnet == null)
      wordnet = new RiWordNet("/WordNet-3.1");

    return wordnet;
  }
}
