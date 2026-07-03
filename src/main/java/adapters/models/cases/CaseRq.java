package adapters.models.cases;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaseRq {

    @Expose
    private String steps_type;
    @Expose
    private String description;
    @Expose
    private String preconditions;
    @Expose
    private String postconditions;
    @Expose
    private String title;
    @Expose
    private int severity;
    @Expose
    private int priority;
    @Expose
    private int behavior;
    @Expose
    private int type;
    @Expose
    private int layer;
    @Expose
    private int is_flaky;
    @Expose
    private int isManual;
    @Expose
    private int status;
    @Expose
    private List<Step> steps;
}
