

def call(String image_name, String username, String password) {
    assert (image_name && username && password)
    sh """
    buildah login -u ${username} -p ${password} docker.io
    buildah push ${username}/${imagename}
    buildah logout docker.io
    """
}