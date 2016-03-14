package rita.remote;

import javax.ws.rs.*;

import rita.RiWordNet;

@Path("remote/RiWordNet")
public class RiWordNetRemote extends RiTaRemote
{
  private static RiWordNet wordnet;

  @GET
  @Path("status")
  @Produces("application/javascript")
  public String status(@QueryParam("callback") String cb)
  {
    return "ok";
  }
    
  @GET
  @Path("getRandomWord/{pos}")
  @Produces("application/javascript")
  public String getRandomWord(@QueryParam("callback") String cb, @PathParam("pos") String pos)
  {
    String result = null;
    try
    {
      result = getRiWordNet().getRandomWord(pos);
    }
    catch (Exception e)
    {
      return toJSONP(cb, e);
    }

    return toJSONP(cb, result);
  }
  
  @GET
  @Path("getBestPos/{query}")
  @Produces("application/javascript")
  public String getBestPos(@QueryParam("callback") String cb, @PathParam("query") String query)
  {
    String result = null;
    try
    {
      result = getRiWordNet().getBestPos(query);
      if (result == null) result = "";
    }
    catch (Exception e)
    {
      return toJSONP(cb, e);
    }

    return toJSONP(cb, result);
  }

  @GET
  @Path("getSynonyms/{query}/{pos}")
  @Produces("application/javascript")
  public String getSynonyms(@QueryParam("callback") String cb,@PathParam("query") String query, @PathParam("pos") String pos)
  {
    String[] result = null;
    try
    {
      result = getRiWordNet().getSynonyms(query, pos);
    }
    catch (Exception e)
    {
      return toJSONP(cb, e);
    }

    return toJSONP(cb, result);
  }
    
  @GET
  @Path("getAllCoordinates/{query}/{pos}")
  @Produces("application/javascript")
  public String getAllCoordinates(@QueryParam("callback") String cb,@PathParam("query") String query, @PathParam("pos") String pos)
  {
    String[] result = null;
    try
    {
      result = getRiWordNet().getAllCoordinates(query, pos);
    }
    catch (Exception e)
    {
      return toJSONP(cb, e);
    } 

    return toJSONP(cb, result);
  }
  
  @GET
  @Path("getAllSynonyms/{query}/{pos}")
  @Produces("application/javascript")
  public String getAllSynonyms(@QueryParam("callback") String cb,@PathParam("query") String query, @PathParam("pos") String pos)
  {
    //System.out.println("RiWordNetRemote.getAllSynonyms() :: "+query);
    String[] result = null;
    try
    {
      result = getRiWordNet().getAllSynonyms(query, pos);
    }
    catch (Exception e)
    {
      return toJSONP(cb, e);
    }

    return toJSONP(cb, result);
  }
  
  @GET
  @Path("getAllDerivedTerms/{query}/{pos}")
  @Produces("application/javascript")
  public String getAllDerivedTerms(@QueryParam("callback") String cb,@PathParam("query") String query, @PathParam("pos") String pos)
  {
    String[] result = null;
    try
    {
      result = getRiWordNet().getAllDerivedTerms(query, pos);
    }
    catch (Exception e)
    {
      return toJSONP(cb, e);
    }

    return toJSONP(cb, result);
  }

  // Boolean --------------------------------------------------------

  @GET
  @Path("isVerb/{query}")
  @Produces("application/javascript")
  public String isVerb(@QueryParam("callback") String cb,@PathParam("query") String query)
  {
    try
    {
      boolean result = getRiWordNet().isVerb(query);
      // System.out.println(query+" -> "+verb);
      return toJSONP(cb, result);
    }
    catch (Exception e)
    {
      return toJSONP(cb, e);
    }
  }

  @GET
  @Path("isAdjective/{query}")
  @Produces("application/javascript")
  public String isAdjective(@QueryParam("callback") String cb,@PathParam("query") String query)
  {
    try
    {
      boolean result = getRiWordNet().isAdjective(query);
      // System.out.println(query+" -> "+verb);
      return toJSONP(cb, result);
    }
    catch (Exception e)
    {
      return toJSONP(cb, e);
    }
  }

  @GET
  @Path("isNoun/{query}")
  @Produces("application/javascript")
  public String isNoun(@QueryParam("callback") String cb,@PathParam("query") String query)
  {
    try
    {
      boolean result = getRiWordNet().isNoun(query);
      // System.out.println(query+" -> "+verb);
      return toJSONP(cb, result);
    }
    catch (Exception e)
    {
      return toJSONP(cb, e);
    }
  }

  @GET
  @Path("isAdverb/{query}")
  @Produces("application/javascript")
  public String isAdverb(@QueryParam("callback") String cb,@PathParam("query") String query)
  {
    try
    {
      boolean result = getRiWordNet().isAdverb(query);
      // System.out.println(query+" -> "+verb);
      return toJSONP(cb, result);
    }
    catch (Exception e)
    {
      return toJSONP(cb, e);
    }
  }
  
  @GET
  @Path("exists/{query}")
  @Produces("application/javascript")
  public String exists(@QueryParam("callback") String cb, @PathParam("query") String query)
  {
    
    try
    {
      boolean result = getRiWordNet().exists(query);
      //System.out.println("exists: "+query+" -> "+result);
      return toJSONP(cb, result);
    }
    catch (Exception e)
    {
      return toJSONP(cb, e);
    }
  }
  
  // Helpers --------------------------------------------------------

  protected RiWordNet getRiWordNet()
  {
    if (wordnet == null) {
      wordnet = new RiWordNet("/WordNet-3.1", true, true); // other options?
      wordnet.useMorphologicalProcessor = true;
    }

    return wordnet;
  }
}
