#!groovy
properties(
    [
        pipelineTriggers([
            upstream(upstreamProjects: "../build-windows/${BRANCH_NAME}",
                     threshold: hudson.model.Result.SUCCESS)
        ])
    ]
)

if (!currentBuild.upstreamBuilds) {
    return
}

sleep 10
currentBuild.upstreamBuilds?.each { b ->
    echo b.getFullProjectName()
}
