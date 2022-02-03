# Retool Notes

* Name query: `students_query`
* Table value: `{{students_query.data}}`
* Disable "Run query automatically"
* Query: ```select * from students where lower(last_name) LIKE  '%' ||{{name_query.value}} || '%'```