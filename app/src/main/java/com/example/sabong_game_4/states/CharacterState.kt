package com.example.sabong_game_4.states

class CharacterState: ICharacterState {
    private val stateBucket = mutableSetOf(States.Idle)
    override fun toJumping() {
        synchronized(stateBucket) {
            stateBucket.removeIf {
                listOf(States.Idle, States.Falling).contains(it)
            }
        }
        stateBucket.add(States.Jumping)
    }

    override fun isJumping(): Boolean {
        return stateBucket.contains(States.Jumping)
    }

    override fun toFalling() {
        synchronized(stateBucket) {
            stateBucket.removeIf {
                listOf(States.Idle, States.Jumping).contains(it)
            }
        }
        stateBucket.add(States.Falling)
    }

    override fun isFalling(): Boolean {
        return stateBucket.contains(States.Falling)
    }

    override fun toRunningRight() {
        synchronized(stateBucket) {
            stateBucket.remove(States.Idle)
            stateBucket.removeIf {
                !listOf(States.Jumping, States.Falling).contains(it)
            }
        }
        stateBucket.add(States.RunningRight)
    }

    override fun toRunningLeft() {
        synchronized(stateBucket) {
            stateBucket.remove(States.Idle)
            stateBucket.removeIf {
                !listOf(States.Jumping, States.Falling).contains(it)
            }
        }
        stateBucket.add(States.RunningLeft)
    }

    override fun toStoppingLeft() {
        synchronized(stateBucket) {
            stateBucket.remove(States.Idle)
            stateBucket.removeIf {
                !listOf(States.Jumping, States.Falling).contains(it)
            }
        }
        stateBucket.add(States.StoppingRunningLeft)
    }

    override fun toStoppingRight() {
        synchronized(stateBucket) {
            stateBucket.remove(States.Idle)
            stateBucket.removeIf {
                !listOf(States.Jumping, States.Falling).contains(it)
            }
        }
        stateBucket.add(States.StoppingRunningRight)
    }

    override fun isMovingHorizontally(): Boolean {
        synchronized(stateBucket) {
            val isMovingInX = stateBucket.find {
                listOf(
                    States.StoppingRunningLeft,
                    States.StoppingRunningRight,
                    States.RunningRight,
                    States.StoppingRunningLeft
                ).contains(it)
            }
            return isMovingInX != null
        }
    }

    override fun toIdle() {
        synchronized(stateBucket) {
            stateBucket.clear()
            stateBucket.add(States.Idle)
        }
    }

    override fun isIdle(): Boolean {
        return stateBucket.contains(States.Idle) && stateBucket.size == 1
    }

    override fun getCurrentState(): Set<States> {
        return stateBucket
    }
}