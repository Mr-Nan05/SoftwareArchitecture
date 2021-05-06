import axios from 'axios'

const students = [
  {
    id: '1',
    firstName: 'John',
    lastName: 'Brown',
    age: 32,
    address: 'New York No. 1 Lake Park',
    tags: ['nice', 'developer'],
  },
  {
    id: '2',
    firstName: 'Jim',
    lastName: 'Green',
    age: 42,
    address: 'London No. 1 Lake Park',
    tags: ['loser'],
  },
  {
    id: '3',
    firstName: 'Joe',
    lastName: 'Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
    tags: ['cool', 'teacher'],
  },
]

export default {
  'GET /students/': (_, response) => {
    let students = []
    let url = 'http://localhost:8008/manager/students'
    axios.get(url).then((result) => {
      console.log(result.data)
      students.concat(result.data['_embedded']['students'])

      console.log(students)
    })
    response.send(students)
  },
  'GET /api/students': (_, response) => {
    response.send(students)
  },
}
