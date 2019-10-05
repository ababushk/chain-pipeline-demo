#!groovy
properties(
    [
        pipelineTriggers([upstream(upstreamProjects: "build-windows", threshold: hudson.model.Result.SUCCESS]),
    ]
)


currentBuild.upstreamBuilds?.each { b ->
    echo b.getFullProjectName()
}
