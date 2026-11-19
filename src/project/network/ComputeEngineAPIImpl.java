package project.network;

import java.util.UUID;

import project.conceptual.ComputationAPI;
import project.handler.JobHandler;
import project.process.DataStorageAPI;

public class ComputeEngineAPIImpl implements ComputeEngineAPI {

    private final JobHandler handler;

    public ComputeEngineAPIImpl(DataStorageAPI storage,ComputationAPI computation) {

        this.handler = new JobHandler(storage, computation);
    }

    @Override
    public JobResponse submitJob(JobRequest request) {

        try {
            handler.execute(request);

            return createResponse(
                    true, "Job completed successfully");

        } catch (Exception exception) {
            return createResponse(
                    false, "Job failed: "
                    + exception.getMessage());
        }
    }

    private JobResponse createResponse(
            boolean accepted, String message) {

        String jobId = UUID.randomUUID().toString();

        return new JobResponse() {

            @Override
            public boolean isAccepted() {
                return accepted;
            }

            @Override
            public String getJobId() {
                return jobId;
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
    }
}