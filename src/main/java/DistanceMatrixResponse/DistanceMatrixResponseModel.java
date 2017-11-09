package DistanceMatrixResponse;

/**
 * Created by oshcherbatyy on 22-02-17.
 */

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "destination_addresses",
        "origin_addresses",
        "rows",
        "status"
})
public class DistanceMatrixResponseModel {

    @JsonProperty("destination_addresses")
    private List<String> destinationAddresses = null;
    @JsonProperty("origin_addresses")
    private List<String> originAddresses = null;
    @JsonProperty("rows")
    private List<Row> rows = null;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public DistanceMatrixResponseModel() {
    }

    /**
     *
     * @param destinationAddresses
     * @param status
     * @param originAddresses
     * @param rows
     */
    public DistanceMatrixResponseModel(List<String> destinationAddresses, List<String> originAddresses, List<Row> rows, String status) {
        super();
        this.destinationAddresses = destinationAddresses;
        this.originAddresses = originAddresses;
        this.rows = rows;
        this.status = status;
    }

    @JsonProperty("destination_addresses")
    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    @JsonProperty("destination_addresses")
    public void setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    @JsonProperty("origin_addresses")
    public List<String> getOriginAddresses() {
        return originAddresses;
    }

    @JsonProperty("origin_addresses")
    public void setOriginAddresses(List<String> originAddresses) {
        this.originAddresses = originAddresses;
    }

    @JsonProperty("rows")
    public List<Row> getRows() {
        return rows;
    }

    @JsonProperty("rows")
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
