CREATE TABLE test.test
(

    `pointId` Int32,

    `dataTime` Int64,

    `val` Float32
)
ENGINE = MergeTree()
PRIMARY KEY (dataTime, pointId)
ORDER BY (dataTime, pointId)
SETTINGS index_granularity = 8192