import request from 'umi-request'

export default {
  namespace: 'students',

  state: [],

  reducers: {
    select(state, { payload }) {
      const { id: targetId } = payload

      return state.filter((e) => e.id === targetId)
    },

    update(_, { payload }) {
      const { students } = payload
      return students
    },

    deleteStudent(state, { payload }) {
      const { id: targetId } = payload

      return state.filter((e) => e.id !== targetId)
    },
  },

  effects: {
    *getAll(_, { call, put }) {
      const response = yield call(
        request.get,
        'http://localhost:8008/manager/students'
      )

      yield put({
        type: 'update',
        payload: {
          students: response['_embedded']['students'],
        },
      })
    },
    *getStudent(id, { call, put }) {
      const response = yield call(
        request.get,
        'http://localhost:8008/manager/students/3'
      )
      yield put({
        type: 'update',
        payload: {
          students: [].concat(response),
        },
      })
    },
    // *delstudent(id, { call, put }) {
    //   yield call(request.delete, 'http://172.27.166.164:8080/students/' + id)
    //   const response = yield call(
    //     request.get,
    //     'http://172.27.166.164:8080/students'
    //   )

    //   yield put({
    //     type: 'update',
    //     payload: {
    //       students: response['_embedded']['students'],
    //     },
    //   })
    // },
  },
}
