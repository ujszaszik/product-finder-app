package ch.galaxus.productfinder.network.query

interface NetworkQuery<ParameterType> {

    /**
     * The GraphQL query String with parameter
     */
    val value: String

    /**
     * The textual representation how the parameter is defined in the Query
     */
    val parameter: String

    /**
     * The method to replace the parameter text with the actual parameter value
     */
    fun acceptParam(param: ParameterType): String

    fun build(param: ParameterType): String {
        return value.replace("{$parameter}", acceptParam(param))
    }
}