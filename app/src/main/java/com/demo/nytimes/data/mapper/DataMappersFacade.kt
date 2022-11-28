package com.demo.nytimes.data.mapper

import com.demo.nytimes.data.model.Results
import com.demo.nytimes.domain.model.*

class DataMappersFacade(
     val mapNews: (jsonProjects: List<Results>) -> List<NyNews>
)