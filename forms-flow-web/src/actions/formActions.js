import ACTION_CONSTANTS from './actionConstants'

export const setFormSubmissionDeleteStatus = (data) => dispatch =>{
    dispatch({
        type:ACTION_CONSTANTS.FORM_SUBMISSION_DELETE,
        payload:data
    })
}
export const setFormSubmissionError = (data) => dispatch =>{
    dispatch({
        type:ACTION_CONSTANTS.FORM_SUBMISSION_ERROR,
        payload:data
    })
}

export const setFormSubmissionLoading = (data) => dispatch =>{
  dispatch({
    type:ACTION_CONSTANTS.IS_FORM_SUBMISSION_LOADING,
    payload:data
  })
}

export const setFormDeleteStatus = (data) => dispatch =>{
    dispatch({
        type:ACTION_CONSTANTS.FORM_DELETE,
        payload:data
    })
}

export const setFormWorkflowSaved = (data) => dispatch =>{
    dispatch({
        type:ACTION_CONSTANTS.IS_FORM_WORKFLOW_SAVED,
        payload:data
    })
}

export const setBPMFormList = (data) => dispatch =>{
  dispatch({
    type:ACTION_CONSTANTS.BPM_FORM_LIST,
    payload:data
  })
}

export const setBPMFormListLoading = (data) => dispatch =>{
  dispatch({
    type:ACTION_CONSTANTS.IS_BPM_FORM_LIST_LOADING,
    payload:data
  })
}



