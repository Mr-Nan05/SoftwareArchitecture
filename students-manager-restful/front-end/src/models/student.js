import request from 'umi-request'

export default {
  namespace: 'student',

  state: {},

  reducers: {
    update(_, { payload }) {
      const { student } = payload
      return student
    },
  },

  effects: {
    *getStudent(id, { call, put }) {
      const response = yield call(
        request.get,
        `http://localhost:8008/manager/students/3`
      )
      yield put({
        type: 'update',
        payload: {
          student: response,
        },
      })
    },
  },
}
