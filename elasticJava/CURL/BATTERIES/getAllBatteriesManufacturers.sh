curl -XGET 'localhost:9200/products/_search?pretty' -H 'Content-Type: application/json' -d'
{
    "query": { "term": {"class" : "batteries"}},
        "aggs" : {
            "langs" : {
                "terms" : { "field" : "manufacturer",  "size" : 500 }
                }
            }
         
}
'


