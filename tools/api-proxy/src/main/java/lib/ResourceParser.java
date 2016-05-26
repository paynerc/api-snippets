package lib;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ResourceParser {
  public static String RESOURCE_METHOD = "method";
  public static String RESOURCE_NAME = "name";
  public static String RESOURCE_CONTENT = "content";

  private JSONObject resourceJson;
  private String resourceName;
  private JSONObject resourceRequest;
  private JSONObject resourceResponse;

  public ResourceParser(JSONArray resourceArrayJson) {
    this.resourceJson = (JSONObject) resourceArrayJson.get(0);
    this.resourceName = (String) this.resourceJson.get(RESOURCE_NAME);
    this.resourceRequest = (JSONObject) this.resourceJson.get("request");
    this.resourceResponse = (JSONObject) this.resourceJson.get("response");
  }

  public String getResourceName() {
    return resourceName;
  }

  public JSONObject getResourceRequest() {
    return this.resourceRequest;
  }

  public JSONObject getResourceResponse() {
    return this.resourceResponse;
  }

  public String getResourceRequestMethod() {
    String method = (String) getResourceRequest().get(RESOURCE_METHOD);

    return method;
  }

  public JSONObject getResourceResponseContent() {
    JSONObject content = (JSONObject) getResourceResponse().get(RESOURCE_CONTENT);

    return content;
  }

  public HashMap<String, Object> getResourceProperties() {
    HashMap<String, Object> resourceProperties = new HashMap<>();
    resourceProperties.put(RESOURCE_NAME, getResourceName());
    resourceProperties.put(RESOURCE_METHOD, getResourceRequestMethod());
    resourceProperties.put(RESOURCE_CONTENT, getResourceResponseContent());

    return resourceProperties;
  }
}
