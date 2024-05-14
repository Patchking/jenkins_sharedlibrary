

def call(String image_name, String credential) {
    // assert (image_name && username && password)
    withCredentials([
        usernamePassword(
            credentialsId: credential,
            usernameVariable: "REGESTRY_LOGIN",
            passwordVariable: "REGESTRY_PASSWORD"
        )  
    ]) {
        sh """
        buildah login -u ${REGESTRY_LOGIN} -p ${REGESTRY_PASSWORD} docker.io
        buildah push ${REGESTRY_LOGIN}/${imagename}
        buildah logout docker.io
        """
    }

}