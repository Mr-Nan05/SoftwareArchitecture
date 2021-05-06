import { useEffect } from 'react'
import { connect } from 'dva'
import ReactJson from 'react-json-view'

function student({
  student,
  dispatch,
  match: {
    params: { id },
  },
}) {
  useEffect(() => {
    dispatch({
      type: 'student/getStudent',
      payload: {
        id: id,
      },
    })
  }, [])

  console.log({ student })
  return (
    <div>
      <h1>student {id} 's Page</h1>
      <div>
        <ReactJson src={student} />
      </div>
    </div>
  )
}

export default connect(({ student }) => ({ student }))(student)
