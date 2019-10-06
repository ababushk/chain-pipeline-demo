#!groovy
properties(
    [
        pipelineTriggers([
            upstream(upstreamProjects: "../multibranch-build-windows/${BRANCH_NAME}",
                     threshold: hudson.model.Result.SUCCESS)
        ])
    ]
)


currentBuild.upstreamBuilds?.each { b ->
    echo b.getFullProjectName()
}
