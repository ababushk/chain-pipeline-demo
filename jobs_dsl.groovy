folder("dsl-chain-folder")
multibranchPipelineJob('dsl-chain-folder/build-windows') {
    triggers {
        // Some kinds of folders are reindexed automatically and immediately upon receipt of an external event.
        periodicFolderTrigger {

            // The maximum amount of time since the last indexing that is allowed to elapse before an indexing is triggered.
            interval("1")

        }
    }
    branchSources {
        branchSource {
            source {
                github {
                    // Specifies a unique ID for this branch source.
                    id("123")
                    // Sets the name of the GitHub Organization or GitHub User Account.
                    repoOwner("ababushk")
                    // Sets the name of the GitHub repository.
                    repository("chain-pipeline-demo")
                    repositoryUrl("https://github.com/ababushk/chain-pipeline-demo")
                    configuredByUrl(true)
                    credentialsId("personal_github")

                    buildForkPRHead(true)
                    // Build fork PRs (merged with base branch).
                    buildForkPRMerge(false)
                    // // Build origin branches.
                    // buildOriginBranch(true)
                    // // Build origin branches also filed as PRs.
                    // buildOriginBranchWithPR(false)
                    // // Build origin PRs (unmerged head).
                    // buildOriginPRHead(true)
                    // // Build origin PRs (merged with base branch).
                    // buildOriginPRMerge(false)


                    traits {
                        // Defines a custom context label to be sent as part of Github Status notifications for this project.
                        notificationContextTrait {
                            // The text of the context label for Github status notifications.
                            contextLabel("build/windows")
                            // Appends the relevant suffix to the context label based on the build type.
                            typeSuffix(false)
                        }

                        // Discovers branches on the repository.
                        gitHubBranchDiscovery {

                            // Determines which branches are discovered.
                            strategyId(1)

                        }
                        // Discovers pull requests where the origin repository is the same as the target repository.
                        originPullRequestDiscoveryTrait {

                            // Determines how pull requests are discovered:
                            // Merging the pull request with the current target branch revision - Discover each pull request once with the discovered revision corresponding to the result of merging with the current revision of the target branch
                            // The current pull request revision - Discover each pull request once with the discovered revision corresponding to the pull request head revision without merging
                            // Both the current pull request revision and the pull request merged with the current target branch revision - Discover each pull request twice.
                            strategyId(2)

                        }
                    }
                }
            }
            // By default (i.e. when empty), everything except tags will be automatically built whenever discovered or changed.
            buildStrategies {
                // Skip initial build on first branch indexing
                skipInitialBuildOnFirstBranchIndexing()
            }
        } // branchSource
    } // branchSources
    orphanedItemStrategy {
        discardOldItems {
            daysToKeep(30)
            numToKeep(100)
        }
    }

    // Sets the project factories for this folder.
    factory {
        workflowBranchProjectFactory {
            // Relative location within the checkout of your Pipeline script.
            scriptPath('build-windows.groovy')
        }

    }

}

multibranchPipelineJob('dsl-chain-folder/functional-windows') {
    triggers {
        // Some kinds of folders are reindexed automatically and immediately upon receipt of an external event.
        periodicFolderTrigger {

            // The maximum amount of time since the last indexing that is allowed to elapse before an indexing is triggered.
            interval("1")

        }
    }
    branchSources {
        branchSource {
            source {
                github {
                    // Specifies a unique ID for this branch source.
                    id("123")
                    // Sets the name of the GitHub Organization or GitHub User Account.
                    repoOwner("ababushk")
                    // Sets the name of the GitHub repository.
                    repository("chain-pipeline-demo")
                    repositoryUrl("https://github.com/ababushk/chain-pipeline-demo")
                    configuredByUrl(true)
                    credentialsId("personal_github")

                    buildForkPRHead(true)
                    // Build fork PRs (merged with base branch).
                    buildForkPRMerge(false)
                    // // Build origin branches.
                    // buildOriginBranch(true)
                    // // Build origin branches also filed as PRs.
                    // buildOriginBranchWithPR(false)
                    // // Build origin PRs (unmerged head).
                    // buildOriginPRHead(true)
                    // // Build origin PRs (merged with base branch).
                    // buildOriginPRMerge(false)


                    traits {
                        // Defines a custom context label to be sent as part of Github Status notifications for this project.
                        notificationContextTrait {
                            // The text of the context label for Github status notifications.
                            contextLabel("functional/windows")
                            // Appends the relevant suffix to the context label based on the build type.
                            typeSuffix(false)
                        }

                        // Discovers branches on the repository.
                        gitHubBranchDiscovery {

                            // Determines which branches are discovered.
                            strategyId(1)

                        }
                        // Discovers pull requests where the origin repository is the same as the target repository.
                        originPullRequestDiscoveryTrait {

                            // Determines how pull requests are discovered:
                            // Merging the pull request with the current target branch revision - Discover each pull request once with the discovered revision corresponding to the result of merging with the current revision of the target branch
                            // The current pull request revision - Discover each pull request once with the discovered revision corresponding to the pull request head revision without merging
                            // Both the current pull request revision and the pull request merged with the current target branch revision - Discover each pull request twice.
                            strategyId(2)

                        }
                    }
                }
            }

        } // branchSource
    } // branchSources
    orphanedItemStrategy {
        discardOldItems {
            daysToKeep(30)
            numToKeep(100)
        }
    }

    // Sets the project factories for this folder.
    factory {
        workflowBranchProjectFactory {
            // Relative location within the checkout of your Pipeline script.
            scriptPath('tests-functional-windows.groovy')
        }

    }

}
