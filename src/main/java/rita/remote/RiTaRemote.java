package rita.remote;

import rita.json.JSONArray;
import rita.json.JSONObject;

public class RiTaRemote
{
  private static final String E = "";

  public String toJSON(String[] s)
  {
    JSONObject result = new JSONObject();
    JSONArray arr = new JSONArray(s);
    result.put("result", arr);
    result.put("error", E);
    return result.toString();
  }

  public String toJSON(String s)
  {
    JSONObject result = new JSONObject();
    result.put("result", s);
    result.put("error", E);
    return result.toString();
  }

  public String toJSON(boolean b)
  {
    JSONObject result = new JSONObject();
    result.put("result", b);
    result.put("error", E);
    return result.toString();
  }

  public String toJSON(Exception e)
  {
    JSONObject result = new JSONObject();
    JSONArray arr = new JSONArray();
    result.put("result", arr);
    result.put("error", e.getMessage());
    return result.toString();
  }

  public String toJSONP(String callback, String[] s)
  {

    return callback + "(" + toJSON(s).toString() + ");";
  }

  public String toJSONP(String callback, boolean b)
  {
    return callback + "(" + toJSON(b).toString() + ");";
  }

  public String toJSONP(String callback, Exception e)
  {
    return callback + "(" + toJSON(e).toString() + ");";
  }

  public String toJSONP(String callback, String s)
  {
    return callback + "(" + toJSON(s).toString() + ");";
  }

}
