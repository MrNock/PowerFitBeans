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
 * This VideoCloud class manages the connection with the Azure Cloud and it is
 * instantiated to download the video recordings of the exercises.
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 4.0 Final version to submit for Unit 4 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class VideoCloud {

    LinkedList<String> azureVideos = new LinkedList<>();
    public static String videoFileAbsoluteTempPath = System.getProperty("java.io.tmpdir");

    final private String CONNECTION_STRING = "DefaultEndpointsProtocol=https;AccountName=myvideoserver;AccountKey=N8qIEKx8aBdswJm2ZjByjSF0JsqCCcB5VAELyQi204KiuLxt2YDWpQmzFnEmsrIQLnZbZkIiIUD3+AStFiz1oQ==;EndpointSuffix=core.windows.net";
    final private String CONTAINER_NAME = "mrnockvideos";

    public VideoCloud() {

        if (videoFileAbsoluteTempPath.isEmpty()) {
            videoFileAbsoluteTempPath = "c:" + File.separator + "temp";
        }

    }

    public void initializeVideoListFromCloud() {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(CONNECTION_STRING).buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(CONTAINER_NAME);

        for (BlobItem blobItem : containerClient.listBlobs()) {
            azureVideos.add(blobItem.getName());
        }

    }

    /**
     * This method is used to check if video file needs to be downloaded to Temp
     * dir
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
