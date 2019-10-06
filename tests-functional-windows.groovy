#!groovy
properties(
    [
        pipelineTriggers([
            upstream(upstreamProjects: "../multibranch-build-windows/${BRANCH_NAME}",
                     threshold: hudson.model.Result.SUCCESS)
        ])
    ]
)

sleep 10
currentBuild.upstreamBuilds?.each { b ->
    echo b.getFullProjectName()
}
