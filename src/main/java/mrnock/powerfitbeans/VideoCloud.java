package mrnock.powerfitbeans;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobClientBuilder;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import java.io.File;
import java.util.LinkedList;

/**
 * <p>
 * This VideoCloud class manages the connection with the Azure Cloud and it is
 * instantiated to download the video recordings of the exercises.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class VideoCloud {

    LinkedList<String> azureVideos = new LinkedList<>();

    /**
     * <p>
     * String with the temporary directory for the video files.</p>
     */
    public static String videoFileAbsoluteTempPath = System.getProperty("java.io.tmpdir");

    /**
     * <p>
     * String with connection details.</p>
     */
    final private String CONNECTION_STRING = "DefaultEndpointsProtocol=https;AccountName=simulapfileserver;"
            + "AccountKey=rARWVR8b+HYR9t3Clc7SSYSKg3ziOhmItZUUdNMqSbV70r8xHhXYDw17dtNF13Ftujtj7UOZBRH5+AStTP81ig==;"
            + "EndpointSuffix=core.windows.net";

    /**
     * <p>
     * String with name of the container in Azure cloud.</p>
     */
    final private String CONTAINER_NAME = "simulapvideoscontainer";

    /**
     * <p>
     * This VideoCloud constructor sets the videoFileAbsoluteTempPath variable
     * to create a temporary directory to support the video player handling
     * performance.</p>
     */
    public VideoCloud() {

        if (videoFileAbsoluteTempPath.isEmpty()) {
            videoFileAbsoluteTempPath = "c:" + File.separator + "temp";
        }

    }

    /**
     * <p>
     * This method initializeVideoListFromCloud starts a Blot list of elements
     * from the cloud.</p>
     */
    public void initializeVideoListFromCloud() {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(CONNECTION_STRING).buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(CONTAINER_NAME);

        for (BlobItem blobItem : containerClient.listBlobs()) {
            azureVideos.add(blobItem.getName());
        }

    }

    /**
     * <p>
     * This method is used to check if video file needs to be downloaded to Temp
     * dir.</p>
     *
     * @param videoFile String with the name of the video to be downloaded.
     * @return boolean with the result
     */
    public boolean downloadVideoIfNecessary(String videoFile) {
        File f = new File(videoFileAbsoluteTempPath + File.separator + videoFile);
        if (!f.exists()) {
            //Checks that the video exists in azure
            if (azureVideos.contains(videoFile)) {
                //Download the video
                BlobClient blobClient = new BlobClientBuilder().connectionString(CONNECTION_STRING)
                        .blobName(videoFile)
                        .containerName(CONTAINER_NAME)
                        .buildClient();
                blobClient.downloadToFile(videoFileAbsoluteTempPath + File.separator + videoFile);

            } else {
                //The video file is not uploaded in azure
                return false;
            }

        }
        return true;
    }

}
