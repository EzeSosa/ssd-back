package com.esosa.ssdbackend.fund_type

import org.springframework.data.mongodb.repository.MongoRepository

interface IFundTypeRepository : MongoRepository<FundType, String>